void keyPressed() {
  switch(key) {

  case 'w':
    theEagle.frontThruster = !theEagle.frontThruster;
    break;
  case 's':
    theEagle.backThruster = !theEagle.backThruster;
    break;   
  case 'a':
    theEagle.leftThruster = !theEagle.leftThruster;
    break;    
  case 'd':
    theEagle.rightThruster = !theEagle.rightThruster;
    break;
  case 'l':
    theLeif.hit = true;
    break;
  }
}
