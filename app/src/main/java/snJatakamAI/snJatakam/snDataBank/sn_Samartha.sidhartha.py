#!pip install requests
#!pip install BeautifulSoup4

mypath = '/Users/sureshnambiar/Desktop/Python/astrology/jyotisha-master/'

import pandas as pd
import requests
from bs4 import BeautifulSoup

#-- category and no. of pages
segments = {'businessman':4, 'politician':9, 'cricket':9, 'hollywood':9, 'bollywood':9, 'musician':9, 'literature':9, 'sports':9, 'criminal':2, 'astrologer':7, 'singer':9, 'scientist':1, 'football':9, 'hockey':2 }

names_url_part = {}
for i in segments:
  names_href = []
  for j in range(segments[i]):
    url = 'http://www.astrosage.com/celebrity-horoscope/default.asp?page='+str(j+1)+"&category="+str(i)
    response = requests.get(url)
    soup = BeautifulSoup(response.content, "html.parser")
    for row in soup.find_all(class_ = 'ui-img-container'):
      names_href.append(row.a['href'])
  names_url_part[str(i)] = names_href


m = pd.DataFrame.from_dict(names_url_part, orient='index')
m = m.transpose()
m.to_csv(mypath + "snJyotish_links.csv", index="Name")

display(m)

#========================
import time
dyt={
  'Date of Birth':[],
  'Information Source':[],
  'Latitude':[],
  'Longitude':[],
  'Name':[],
  'Place of Birth':[],
  'Segment':[],
  'Time Zone':[],
  'Time of Birth':[]
  }

cnt = 1
totalTimeStart = time.time()
totalTimeEnd = time.time()
for l in names_url_part:
   for j in names_url_part[str(l)]:
     #https://celebrity.astrosage.com/donald-trump-horoscope.asp
     #url = "https://celebrity.astrosage.com/celebrity-horoscope/" + str(j)
     if len(str(j)) <= 0:
        continue
     url = "http://www.astrosage.com/celebrity-horoscope/" + str(j)
     #print(url)
     start = time.time()
     try:
       response = requests.get(url)
     except:
       continue
     soup = BeautifulSoup(response.content, 'html.parser')
     for row in soup.find_all(class_ = 'celebcont', limit=8):
       try:
          #print(str(row.b.contents[0]).strip(":"))
          #print(str(row.contents[2]).strip())
          dyt[str(row.b.contents[0]).strip(":")].append(str(row.contents[2]).strip())
       except:
          continue
     dyt['Segment'].append(str(l))
     end = time.time() 
     print(str(cnt) + ":" + str(end - start))
     cnt = cnt + 1
     totalTimeEnd = totalTimeEnd + (end - start)
     #if cnt > 20000:
     #   break
   #if cnt > 20000:
     #break
        
print("Total Time taken = " + str(totalTimeEnd - totalTimeStart))     

mDtl = pd.DataFrame.from_dict(dyt, orient='index')
mDtl = mDtl.transpose()
mDtl.to_csv(mypath + "snJyotish_charts.csv", index="Name")
display(mDtl)


/*
##-----------------------------
import new_sdk
userID = '60xxxx'
apiKey = "090c8c60"
resource = 'planets'

connector = new_sdk.VRClient(userID, apiKey)
saving_dict = []
for person in dict_data:
  saving_n = {}
  pl_details = connector.call(resource, person['date'], person['month'], person['year'], person['minute'], person['latitude'], person['longitude'], person['timezone'])
  #print(pl_details)
  saving_n['Name'] = person['Name']
  savng_n['Segment'] = person['Segment']
  saving_n['planets'] = pl_details
  saving_dict.append(saving_n)


with open(mypath + 'saving_data.txt', 'w') as file:
  file.write(json.dumps(saving_dict))

*/


#-----------------------
#!pip install imblearn
#!pip install catboost

from sklearn.model_selection import train_test_split
from imblearn.over_sampling import SMOTE
from catboost import CatBoostClassifier
from catboost import Pool
from sklearn.model_selection import KFold

smote = SMOTE('minority')

model = CatBoostClassifier(
  iterations = 50,
  learning_rate = 0.3,
  random_strength = 0.20,
  depth = 7,
  verbose = False,
  loss_function = 'MultiClass',
  eval_metric = 'Accuracy',
  leaf_estimation_method = 'Newton'
  )

matrix = []
for t_class in two_cat:
  #selecting two categories at a time
  twoclass_data = full_data[full_data['Segment'].isin(t_class)]
  y_variable = twoclass_data['Segment']
  x_variable = twoclass_data.drop(['Segment'], axis=1)
  #defining splits to be performed
  cv = KFold(n_splits=2, random_state=42, shuffle=True)
  scores = {}

  for train_index, test_index in cv.split(x_variable):
    X_train, X_test, y_train, y_test = x_variable.ilor[train_index], x_variable.iloc[test_index], y_variable.iloc[train_index], y_variable.iloc[test_index]
    print(X_train.shape)
    # taking care of under sampling in data.
    X_sm, y_sm = smote.fit_sample(X_train, y_train)
    print (X_sm.shape)
    train_pool = Pool(data=X_sm, label=y_sm)
    test_pool = Pool(data=X_test, label=y_test)
    model.fit(train_pool, plot=True, eval_set = test_pool)
    scores['Pair'] = t_class
    scores['Accuracy'] = model.best_score_['validation_0']['Accuracy']
    print(t_class, model.best_score_['validation_0']['Accuracy'])
    matrix.append(scores)


 #scores
