class Dashboard {

  Dashboard() {
  }

  void update() {
    displayDash();
    displayXspeedDial();
    displayXspeedDial();   
  //  displayFuelDial();
  }
  
  void displayDash(){
    pushMatrix();
    //image(Matare, 0, 0);
  }
  
  void displayXspeedDial(){
   
    float xspeed = theEagle.velocity.x;
    pushMatrix();
    textSize(100);
   text(xspeed + "km/h", 100 , 100);
    fill (255,0,0);
    popMatrix();
  }
  
}
