def buildApp() {
  echo 'budowanie apki'
}

def testApp() {
  echo 'testowanie apki'
}

def deployApp() {
  echo 'wdrożenie apki'
  echo "wersja ${VERSION}"
}

return this
