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
csvFileName = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Results/results.csv'
listOfPlantAttributes = []
oneString = ""

# A list of plant URLs taken from the HTML at
# http://www.newmoonnursery.com/index.cfm/fuseaction/plants.main/alphaKey/ALL/index.htm
# each line in text file has something like: plant/Agastache-Blue-Fortune
PlantList_00 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/00_AllPlants.txt'
PlantList_01 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/01_AlkalineSoilTolerantList.txt'
PlantList_02 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/02_BirdButterflyBugGardensList.txt'
PlantList_03 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/03_DroughtTolerantList.txt'
PlantList_04 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/04_GrassesList.txt'
PlantList_05 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/05_GroundhogResistantList.txt'
PlantList_06 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/06_LandscapeOrnamentalsList.txt'
PlantList_07 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/07_MeadowList.txt'
PlantList_08 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/08_NorthAmericanNativeList.txt'
PlantList_09 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/09_PerennialsList.txt'
PlantList_10 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/10_PhytoremediationList.txt'
PlantList_11 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/11_RabbitResistantList.txt'
PlantList_12 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/12_RainGardensList.txt'
PlantList_13 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/13_RestorationConservationList.txt'
PlantList_14 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/14_RooftopGardenList.txt'
PlantList_15 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/15_ShrubList.txt'
PlantList_16 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/16_SoilStabilizationList.txt'
PlantList_17 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/17_StormwaterManagementList.txt'
PlantList_18 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/18_VinesList.txt'
PlantList_19 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/19_WetlandsList.txt'
PlantList_20 = 'C:/Users/ts140/eclipse-workspace-java-hp/team-11-2/scraper/NewMoonNursery/Lists/20_WoodlandList.txt'

pathToURLList = PlantList_15

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
    oneString += oneString.join(result) + \
        ";" if result != [] else oneString.join(";")

    result = [iter for iter in cleanedArray if "Spread" in iter]
    oneString += oneString.join(result) + \
        ";" if result != [] else oneString.join(";")

    result = [iter for iter in cleanedArray if "Spacing" in iter]
    oneString += oneString.join(result) + \
        ";" if result != [] else oneString.join(";")

    result = [iter for iter in cleanedArray if "USDA Hardiness" in iter]
    oneString += oneString.join(result) + \
        ";" if result != [] else oneString.join(";")

    result = [iter for iter in cleanedArray if "Bloom Color" in iter]
    oneString += oneString.join(result) + \
        ";" if result != [] else oneString.join(";")

    # Clean up the string
    oneString = oneString.replace("Height: ", "")
    oneString = oneString.replace("Spacing: ", "")
    oneString = oneString.replace("Spread: ", "")
    oneString = oneString.replace("USDA Hardiness Zone: ", "")
    oneString = oneString.replace("Bloom Color: ", "")
    oneString = oneString.replace(";;", "; ;")

    print("Cleaned results: " + oneString)

    csvRows.append([oneString])
    oneString = ""
    sleep(5)

with open(csvFileName, 'w', newline="") as csvfile:
    csvwriter = csv.writer(csvfile, quoting=csv.QUOTE_NONE,
                           escapechar='\\', delimiter=";")
    csvwriter.writerow(csvFields)
    csvwriter.writerows(csvRows)
