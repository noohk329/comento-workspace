import requests
import pymysql
import datetime

def get_request_query(url, operation, params, serviceKey):
    import urllib.parse as urlparse
    params = urlparse.urlencode(params)
    request_query = url + '/' + operation + '?' + params + '&' + 'serviceKey' + '=' + serviceKey
    return request_query

def saveHoliday(): # 2015년부터 2023년 공휴일 DB에 저장
    # 요청 URL과 오퍼레이션
    URL = 'http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService'
    OPERATION= 'getRestDeInfo' # 국경일
    # 파라미터
    SERVICEKEY = 'KIPCztE7n%2B2A41eMsgmwYNJ7Z4cZo9%2FQgevdSKUsAWH30gSpwOFtnKwP7BuzoYGsJ8QnDX3taOuyFAc17t2POA%3D%3D'
    TYPE = 'json'

    conn = pymysql.connect(host='localhost', port=3306, user='root', password='123456', db='statistc', charset='utf8')
    cur = conn.cursor()

    startyear = 2015
    endyear = 2023
    for i in range(startyear, endyear):
        solYear = str(i)
        PARAMS = {'solYear': solYear, 'numOfRows':100, '_type':TYPE}
        request_query = get_request_query(URL, OPERATION, PARAMS, SERVICEKEY)
        print('request_query:', request_query)
        response = requests.get(url=request_query)

        if True == response.ok:
            json_object = response.json()

            totalCnt = json_object['response']['body']['totalCount']
            holidays = json_object['response']['body']['items']['item']

            for i in range(0, totalCnt):
                # print(holidays[i]['dateName'])
                # print(str(holidays[i]['locdate'])[2:8])
                date = str(holidays[i]['locdate'])[2:8]
                name = holidays[i]['dateName']
                sql = 'INSERT INTO holiday (date, holidayname) VALUES("'+date+'","'+name+'")'
                cur.execute(sql)

    conn.commit()
    conn.close()

saveHoliday()