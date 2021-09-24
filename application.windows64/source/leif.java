import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class leif extends PApplet {



Lander theEagle;
Leif theLeif;
Planet thePlanet;
Rock[] rocks;
Dashboard theDash;

float gravity = 0.003f;
int numRocks = 60;
float leifSpeed = 1.0f;
int tankVolume = 1000;
float minRockDist = 30;
float minLandSpeed = 0.2f;

int state = 1;

PImage theEagleImage, skyImage, theLeifImage, FlameImage, mountainImage, rockImage1, rockImage2, rockImage3, groundImage, theLeifGameOverImage, theLeifGameOverImage2, dashImage, explosionImage, GameOverImage;
SoundFile leifDirectionSound, thrustStartSound, explosionSound, leifLaughSound;

public void setup() {

  

  // Load the images
  theEagleImage = loadImage("bilder/theEagle.png");
  theLeifImage = loadImage("bilder/leif in an alien saucer 1.png");
  skyImage = loadImage("bilder/himlen2.png");
  FlameImage = loadImage("bilder/Flame.png");
  theLeifGameOverImage = loadImage("bilder/big leif-1.png");
  theLeifGameOverImage2 = loadImage("bilder/big leif-2.png");
  mountainImage = loadImage("bilder/moon background-1.png");
  rockImage1 = loadImage("bilder/rock1.png");
  rockImage2 = loadImage("bilder/rock2.png");
  rockImage3 = loadImage("bilder/rock3.png");
  groundImage = loadImage("bilder/ground.JPG");
  dashImage = loadImage("bilder/Dash.png");
  explosionImage = loadImage("bilder/explosion.png");
  GameOverImage = loadImage("bilder/GAME OVER.png");

  leifDirectionSound = new SoundFile(this, "ljud/leifDirectionChange.wav");
  thrustStartSound = new SoundFile(this, "ljud/thrustStart.wav");
  explosionSound = new SoundFile(this, "ljud/explosion.wav");
  leifLaughSound = new SoundFile(this, "ljud/leifLaugh.wav");

  // Create all objects
  theEagle = new Lander();
  theLeif = new Leif();
  thePlanet = new Planet();
  rocks = new Rock[numRocks];
  theDash = new Dashboard();
  for (int i = 0; i < numRocks; i++) {
    if (i % 3 == 0) {
      rocks[i] = new Rock(random(0, width), random(PApplet.parseFloat(height - 150), PApplet.parseFloat(height)), rockImage1);
    } else if (i % 3 == 1) {
      rocks[i] = new Rock(random(0, width), random(PApplet.parseFloat(height - 150), PApplet.parseFloat(height)), rockImage2);
    } else {
      rocks[i] = new Rock(random(0, width), random(PApplet.parseFloat(height - 150), PApplet.parseFloat(height)), rockImage3);
    }
  }
}

public void draw() {

  // Game state
  if (state == 1) {

    // Update objects
    thePlanet.update();
    theDash.update();
    for (int i = 0; i < numRocks; i++) {
      rocks[i].update();
    }
    theEagle.update();
    theLeif.update();

    // Check for collision with Leif
    collisionCheck();
  }


  // State for collision with Leif
  if (state == 2) { 
    gameOverLeif();
  }



  // Landing state
  if (state == 3) {

    if (abs(theEagle.velocity.x) > minLandSpeed || abs(theEagle.velocity.y) > minLandSpeed) {
      gameOverSpeedLanding();
      noLoop();
    } else if (checkCollisionRocks()) {
      gameOverRockyLanding();
      noLoop();
    } else {
      gameOverWin();
      noLoop();
    }
  }
}
public void gameOverLeif() {

  // Game over screen
  pushMatrix();
  translate(width/2-200, height/2-100);
  image(theLeifGameOverImage, 0, 25);
  image(GameOverImage, -100, -150);
  text("LEIF CAUGHT UP WITH YOU!", 25, 25);
  popMatrix();
  leifLaughSound.play();
}

public void gameOverSpeedLanding() {

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

public void gameOverRockyLanding() {

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


public void gameOverWin() {

  // Code for visual crash


  // Temporary game over screen
  pushMatrix();
  translate(width/2-200, height/2-100);
  image(GameOverImage, -100, -125);
  text("YOU WIN!", 100, 50);
  popMatrix();
}
class Dashboard {

  Dashboard() {
  }

  public void update() {
    displayDash();
    displayXspeedDial(); 
    displayYspeedDial();
    displayFuelDial();
  }
  
  
  
  public void displayXspeedDial(){
   
    float xspeed = theEagle.velocity.x;
    pushMatrix();
    textSize(30);
   text(round(xspeed*100) + "km/h", 23 , 79);
    fill (255,255,255);
    popMatrix();
  }
  public void displayDash(){
    pushMatrix();
    translate(-29,-198);
    image(dashImage, 0, 0);
    popMatrix();
  }
  public void displayYspeedDial(){
    
    float yspeed = theEagle.velocity.y;
    pushMatrix();
    textSize(30);
   text(round(yspeed*100) + "km/h", 241 , 79);
    fill (255,0,0);
    popMatrix();
    
  }
  public void displayFuelDial(){
   
    float fuel = theEagle.fuelRem;
    pushMatrix();
    textSize(25);
   text(round(100*theEagle.fuelRem/tankVolume) + "%", 170 , 76);
    fill (255,255,255);
    popMatrix();
  }
  
    
    
  
}
class Lander {

  PVector position;
  PVector velocity;
  PVector acceleration;
  PVector totalForce;

  float thrusterForce = 0.8f;
  float mass = 100;
  float fuelRem;

  Boolean frontThruster = false;
  Boolean backThruster = false;
  Boolean leftThruster = false;
  Boolean rightThruster = false;

  Lander() {
    position = new PVector(0, 0);
    velocity = new PVector(0.3f, 0.3f);
    acceleration = new PVector(0, 0);
    totalForce = new PVector(0, 0);
    fuelRem = tankVolume;
  }

  public void display() {
    pushMatrix();
    translate(position.x, position.y);
    image(theEagleImage, 0, 0);

    if (frontThruster || backThruster || leftThruster || rightThruster) {
      thrustStartSound.play();
    }

    if (frontThruster && (fuelRem > 0) ) {
      pushMatrix();
      translate(-9, -50);
      image(FlameImage, 0, 0);
      popMatrix();
    }
    if (backThruster && (fuelRem > 0) ) {
      pushMatrix();
      translate(90, 145);
      rotate(radians(180));
      image(FlameImage, 0, 0);
      popMatrix();
    }
    if (leftThruster && (fuelRem > 0) ) {
      pushMatrix();
      translate(-50, 100);
      rotate(radians(-90));
      image(FlameImage, 0, 0);
      popMatrix();
    }
    if (rightThruster && (fuelRem > 0) ) {
      pushMatrix();
      translate(130, 0);
      rotate(radians(90));
      image(FlameImage, 0, 0);
      popMatrix();
    }

    popMatrix();
  }

  public void update() {      // körs varje frame

    //Calculate total force
    totalForce.mult(0);

    if (frontThruster) {

      if (fuelRem > 0) {
        totalForce.add(0, thrusterForce);
        fuelRem--;
      }
    }
    if (backThruster) {

      if (fuelRem > 0) {
        totalForce.add(0, -thrusterForce);
        fuelRem--;
      }
    }
    if (leftThruster) {

      if (fuelRem > 0) {
        totalForce.add(thrusterForce, 0);
        fuelRem--;
      }
    }
    if (rightThruster) {

      if (fuelRem > 0) {
        totalForce.add(-thrusterForce, 0);
        fuelRem--;
      }
    }
    totalForce.add(0, gravity*mass);

    acceleration = PVector.div(totalForce, mass);
    velocity.add(acceleration);
    position.add(velocity);

    display();
  }
}
class Leif {

  PVector position;
  PVector velocity;
  PVector acceleration;

  float speed = leifSpeed;

  Leif() {
    position = new PVector(600, 0);
    velocity = new PVector(-0.3f, 0.3f);
    acceleration = new PVector(0, 0);
  }

  public void display() {
    pushMatrix();
    translate(position.x, position.y);
    image(theLeifImage, 0, 0);
    popMatrix();
  }

  public void update() {      // körs varje frame

    position.add(velocity);
    velocity.add(acceleration);

    display();

    if (position.x < 0) {
      velocity.x = velocity.x * -1;
    }

    if (position.y < 0) {
      velocity.y = velocity.y * -1;
    }

    if (position.y > height-40) {
      velocity.y = velocity.y * -1;
    }

    if (position.x > width-50) {
      velocity.x = velocity.x * -1;
    }

    if (frameCount % 200 == 0) {
      velocity = PVector.sub(theEagle.position, position);
      velocity.setMag(speed);
      leifDirectionSound.play();
    }
  }
}
class Planet {

  Planet() {
 
    
 
  }

  

  public void update() {      // körs varje frame
      image(skyImage, 0, 0);
      image(mountainImage, 0, 0);
      image(groundImage, 0, 450);
  }
}
class Rock {

  PVector position;
  PImage rockImage;

  Rock(float x,float y, PImage _rockImage) {
    position = new PVector(x,y);
    rockImage = _rockImage;
  }

  public void display() {
    pushMatrix();
    translate(position.x, position.y);
    image(rockImage, -rockImage.width/2, -rockImage.height/2);
    popMatrix();
  }

  public void update() {      // körs varje frame
    display();
  }
}
public void collisionCheck() {

  if (theEagle.position.dist(theLeif.position) < 40) {
    state = 2;
  }

  if (theEagle.position.y > height - theEagleImage.height) {
    state = 3;
  }
}


public boolean checkCollisionRocks() {
  
  PVector theEagleLandingPos = new PVector(theEagle.position.x + theEagleImage.width / 2, theEagle.position.y + theEagleImage.height);
  for (int i = 0; i < numRocks; i++) {
    if (theEagleLandingPos.dist(rocks[i].position) < minRockDist) {
      return true;
    }
  }
  return false;
}
public void keyPressed() {
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
  case ' ':
    state = 3;
    break;
  }
}
  public void settings() {  size(800, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "leif" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
