Lander theEagle;
Leif theLeif;
Planet thePlanet;
Rock[] rocks;

float gravity = 0.003;
int numRocks = 70;
int state = 1;

PImage theEagleImage, skyImage, theLeifImage, FlameImage, mountainImage, rockImage1, rockImage2, rockImage3, groundImage, theLeifGameOverImage, theLeifGameOverImage2;

void setup() {

  size(800, 600);

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


  theEagle = new Lander();
  theLeif = new Leif();
  thePlanet = new Planet();
  rocks = new Rock[numRocks];
  for (int i = 0; i < numRocks; i++) {
    if (i % 3 == 0) {
      rocks[i] = new Rock(random(0, width), random(float(height - 150), float(height)), rockImage1);
    } else if (i % 3 == 1) {
      rocks[i] = new Rock(random(0, width), random(float(height - 150), float(height)), rockImage2);
    } else {
      rocks[i] = new Rock(random(0, width), random(float(height - 150), float(height)), rockImage3);
    }
  }
}

void draw() {

  // Game state
  if (state == 1) {
    thePlanet.update();


    for (int i = 0; i < numRocks; i++) {
      rocks[i].update();
    }
    theEagle.update();
    theLeif.update();

    collisionCheck();
  }

  // Collision with Leif
  if (state == 2) { 
    pushMatrix();
    translate(width/2, height/2);
    image(theLeifGameOverImage, 0, 0);
    popMatrix();
  }

  // Landing 
  if (state == 3) {
    
    noLoop();
    
    
    // Landing code here
  }
}
