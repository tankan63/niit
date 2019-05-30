#program to input a URL and display the title a meta description tags from URL
from bs4 import BeauifulSoup #bs4 module not found, not installed prolly
page=input("Enter a URL: ")
soup=BeautifulSoup(page, "html.parser")
print(soup.title)
print(soup.meta)
