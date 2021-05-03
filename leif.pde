Lander theEagle;
Leif theLeif;
Planet thePlanet;

PImage theEagleImage, skyImage, theLeifImage, FlameImage, mountainImage, rockImage, groundImage;

float gravity = 0.003;

void setup() {

  size(800, 600);

  theEagleImage = loadImage("bilder/theEagle.png");
  theLeifImage = loadImage("bilder/leif in an alien saucer 1.png");
  skyImage = loadImage("bilder/himlen2.png");
  FlameImage = loadImage("bilder/Flame.png");
  mountainImage = loadImage("bilder/moon background-1.png");
 // groundImage = loadImage("");

  theEagle = new Lander();
  theLeif = new Leif();
  thePlanet = new Planet();
}

void draw() {

  thePlanet.update();
  theEagle.update();
  theLeif.update();
  
 // collisionCheck();
}
