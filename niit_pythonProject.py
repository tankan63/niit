''' python project to build an SEO tool to input data in an excel sheet and 
find related tags in the HTML content of a website, thus printing the 
tags onto the python shell '''

from pyexcel_xls import read_data							''' blah blah blah
from bs4 import BeautifulSoup									import all the methods from module
from urllib.request import urlopen								do remember to Win+R(cmd->pip install) first
import xlsxwriter													then code the rest. '''

exBook=xlsxwriter.workbook('website.xlsx')				#create an excel workbook and sheet for website name
exSheet=exBook.add_worksheet()
exBook.close()  												#now add the data according to the project


data=read_data('website.xlsx')								#not sure about this one, please try :/
for sheetname, values in data.items():
	url=values[0]
	print(url)
	print('-'*20)
	hyperLink=urlopen(url)
	html=hyperLink.read().decode('utf-8')
	
	htSoup=BeautifulSoup(html, 'html.parser')				#straightforward, bs4 to display the html content	
	meta=htSoup.find_all('meta')
	desc=htSoup.find(attrs={'name': 'Description'})		#again, not sure what's going on here
	try:															#try except blocks...might not be sure why.	
		data=desc['content']									#matches attribute 'content' and that is new value of data variable (???)
		keywords=[x.strip() for x in data.split(" , ")]		#first splits data string as keywords. removing whitespaces to make a list of words
		for wr in keywords:									#for loop, will print said keywords
			print(wr)
	except Exception as e:									#???!?!?!?!?! WHAT WHY 	
		print('Hmmm...something's not right here.')		#didn't even bother copying the original code...that shit's fucked right up
		
