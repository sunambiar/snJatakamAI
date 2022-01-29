#!/usr/bin/env python
# coding: utf-8

# In[1]:


import pandas as pd
import json


# In[2]:


# load data using Python JSON module
with open('sample.json','r') as f:
    data = json.loads(f.read())
    
df = pd.json_normalize(data)


# In[ ]:





# In[ ]:





# In[ ]:





# In[3]:


## Separating X and y
# The columns should be int,float or bool

X = df.loc[:, df.columns != "to_predict"]
y = df.loc[:,"to_predict"]


# In[4]:


## If the columns are categorical need to do one hot encoding
encoder_df = pd.get_dummies(X['gender'])
X = X.join(encoder_df)


# In[5]:


## Changing all required columns to numeric
X = X[['age','address.streetAddress','address.postalCode','Male','man']].apply(pd.to_numeric)


# In[ ]:





# In[6]:



# xgboost for feature importance on a regression problem
from sklearn.datasets import make_regression
from xgboost import XGBRegressor
from matplotlib import pyplot


# getting sample dataset of 1000 rows because I have only 2 rows means no learning
X, y = make_regression(n_samples=1000, n_features=10, n_informative=5, random_state=1)



# define the model
model = XGBRegressor()
# fit the model
model.fit(X, y)
# get importance
importance = model.feature_importances_
# summarize feature importance
for i,v in enumerate(importance):
	print('Feature: %0d, Score: %.5f' % (i,v))
# plot feature importance
pyplot.bar([x for x in range(len(importance))], importance)
pyplot.show()


# In[ ]:




