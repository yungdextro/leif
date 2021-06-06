void gameOverLeif() {

  // Game over screen
  pushMatrix();
  translate(width/2-200, height/2-100);
  image(theLeifGameOverImage, 0, 25);
  image(GameOverImage, -100, -150);
  text("LEIF CAUGHT UP WITH YOU!", 25, 25);
  popMatrix();
  leifLaughSound.play();
}

void gameOverSpeedLanding() {

  // Code for visual crash
  pushMatrix();
  translate(theEagle.position.x-30, theEagle.position.y-50);
  explosionImage.resize(175, 175);
  image(explosionImage, 0, 0);
  popMatrix();
  explosionSound.play();

  // Temporary game over screen
  pushMatrix();
  translate(width/2-200, height/2-100);
  image(theLeifGameOverImage, 0, 25);
  image(GameOverImage, -100, -125);
  text("YOU LANDED WITH TOO MUCH SPEED!", -30, 50);
  popMatrix();
}

void gameOverRockyLanding() {

  // Code for visual crash


  // Temporary game over screen
  pushMatrix();
  translate(width/2-200, height/2-100);
  image(theLeifGameOverImage, 0, 25);
  image(GameOverImage, -100, -125);
  text("YOU LANDED ON A ROCK!", 25, 50);
  popMatrix();

  explosionSound.play();
}


void gameOverWin() {

  // Code for visual crash


  // Temporary game over screen
  pushMatrix();
  translate(width/2-200, height/2-100);
  image(GameOverImage, -100, -125);
  text("YOU WIN!", 100, 50);
  popMatrix();
}
