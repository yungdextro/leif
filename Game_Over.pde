void gameOverLeif() {
  
  // Temporary game over screen
  pushMatrix();
  translate(width/2, height/2);
  image(theLeifGameOverImage, 0, 0);
  popMatrix();
}

void gameOverSpeedLanding() {
  
  // Code for visual crash
  pushMatrix();
  translate(theEagle.position.x-30, theEagle.position.y-50);
  explosionImage.resize(175, 175);
  image(explosionImage, 0, 0);
  popMatrix(); 
  
  // Temporary game over screen
  pushMatrix();
  translate(width/2, height/2);
  image(theLeifGameOverImage, 0, 0);
  popMatrix();
  
}

void gameOverRockyLanding() {
  
   // Code for visual crash
    
  
  // Temporary game over screen
  pushMatrix();
  translate(width/2, height/2);
  image(theLeifGameOverImage, 0, 0);
  popMatrix();
  
}
