import csv
import re
from contextlib import closing
from time import sleep

from bs4 import BeautifulSoup
from requests import get
from requests.exceptions import RequestException


"""
Written by Haseebullah Siddiqui
A web scraper for http://www.newmoonnursery.com/ with slightly modified code
from https://realpython.com/python-web-scraping-practical-introduction/
for the three functions at the top
"""

def simple_get(url):
    try:
        with closing(get(url, stream=True)) as resp:
            if is_good_response(resp):
                return resp.content
            else:
                return None

    except RequestException as e:
        log_error('Error during requests to {0} : {1}'.format(url, str(e)))
        return None


def is_good_response(resp):
    content_type = resp.headers['Content-Type'].lower()
    return (resp.status_code == 200
            and content_type is not None
            and content_type.find('html') > -1)


def log_error(e):
    print(e)


csvFields = ['Plant Botanical Name', 'Height',
             'Spread', 'Spacing', 'USDA Hardiness Zone', 'Bloom Color']
csvRows = []
csvFileName = 'PATH/TO/CSV/.csv'
listOfPlantAttributes = []
oneString = ""

# A list of plant URLs taken from the HTML at
# http://www.newmoonnursery.com/index.cfm/fuseaction/plants.main/alphaKey/ALL/index.htm
# each line in text file has something like: plant/Agastache-Blue-Fortune
pathToURLList = 'PATH/TO/LIST/OF/URLs.txt'

urlBase = 'http://www.newmoonnursery.com/'

listOfPlantURLs = []

with open(pathToURLList, newline="") as fp:
    for cnt, line in enumerate(fp):
        listOfPlantURLs.append(urlBase + line.strip())

for url in listOfPlantURLs:
    print("Current URL: " + url)
    raw_html = simple_get(url)
    soup = BeautifulSoup(raw_html, 'html.parser')
    
    # get plant name
    name_box = soup.find('h2', attrs={'class': 'layoutA'})
    plantName = name_box.text.strip()
    oneString += plantName + ";"
    # end get plant name

    # put plant attributes into one list
    listOfPlantAttributes = soup.find_all('div', attrs={'class': 'attribute'})

    cleanedArray = []
    cleanedArray.append(plantName)

    for element in listOfPlantAttributes:
        cleanedArray.append(element.text.strip())

    result = [iter for iter in cleanedArray if "Height" in iter]
    oneString += oneString.join(result) + ";" if result != [] else oneString.join(";")
    
    result = [iter for iter in cleanedArray if "Spread" in iter]
    oneString += oneString.join(result) + ";" if result != [] else oneString.join(";")

    result = [iter for iter in cleanedArray if "Spacing" in iter]
    oneString += oneString.join(result) + ";" if result != [] else oneString.join(";")

    result = [iter for iter in cleanedArray if "USDA Hardiness" in iter]
    oneString += oneString.join(result) + ";" if result != [] else oneString.join(";")

    result = [iter for iter in cleanedArray if "Bloom Color" in iter]
    oneString += oneString.join(result) + ";" if result != [] else oneString.join(";")

    csvRows.append([oneString])
    oneString = ""
    sleep(5)

# after this I replaced the '\' with '' and replaced ';;' with '; ;'
# from the resulting CSV with a text replacement tool
with open(csvFileName, 'w', newline="") as csvfile:
    csvwriter = csv.writer(csvfile, quoting=csv.QUOTE_NONE, escapechar='\\', delimiter=";")
    csvwriter.writerow(csvFields)
    csvwriter.writerows(csvRows)
