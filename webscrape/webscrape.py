import requests
import json
from bs4 import BeautifulSoup

#Extract Table info
URL = 'https://www.worldometers.info/coronavirus/'
post_url = 'http://127.0.0.1:8090/loadjson'
page = requests.get(URL)
soup = BeautifulSoup(page.content, 'html.parser')
results = soup.find(id='main_table_countries_today')

#Extract Table header info
headings = []
table_head = results.find('thead')
for row in table_head.find_all('th'):
    headings.append(row.text)


#Extract country info
country_body = results.find_all('tbody')[0]
i = 0
countries = []
country_dict =	{}
for row in country_body.find_all('tr'):

    for col in row.find_all('td'):
        country_dict[headings[i]] = col.text.strip()
        i += 1

    params = {'json':json.dumps(country_dict)}
    r = requests.get(url = post_url, params = params)
    i = 0

#Post Info
# with open('my_settings.json') as json_data:
#     config = json.load(countries)
# data = json.dumps(countries)
# print(data)
# {"Country,Other": " Togo ", "TotalCases": "1", "NewCases": " ", "TotalDeaths": " ", "NewDeaths": " ", "TotalRecovered": " ", "ActiveCases": " 1 ", "Serious,Critical": " ", "Tot\u00a0Cases/1M pop": "0.1"}
# page = requests.post(https://www.worldometers.info/coronavirus/)
# post_url = 'https://www.worldometers.info/loadjson'
# params = {'json':data}
# r = requests.get(url = post_url, params = params)