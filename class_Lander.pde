class Lander {

  PVector position;
  PVector velocity;
  PVector acceleration;
  PVector totalForce;

  float thrusterForce = 1.2;
  float mass = 100;

  Boolean frontThruster = false;
  Boolean backThruster = false;
  Boolean leftThruster = false;
  Boolean rightThruster = false;


  Lander() {
    position = new PVector(0,0);
    velocity = new PVector(0.3, 0.3);
    acceleration = new PVector(0, 0);
    totalForce = new PVector(0, 0);
  }

  void display() {
    pushMatrix();
    translate(position.x, position.y);
    image(theEagleImage, 0, 0);
    popMatrix();
  }

  void update() {      // körs varje frame

    //Calculate total force
    totalForce.mult(0);
    if (frontThruster) {
      totalForce.add(0, thrusterForce);
    }
    if (backThruster) {
      totalForce.add(0, -thrusterForce);
    }
    if (leftThruster) {
      totalForce.add(thrusterForce, 0);
    }
    if (rightThruster) {
      totalForce.add(-thrusterForce, 0);
    }
    totalForce.add(0, gravity*mass);

    acceleration = PVector.div(totalForce, mass);

    position.add(velocity);
    velocity.add(acceleration);

    display();
  }
}
