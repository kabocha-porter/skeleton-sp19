public class Body{
   public static double gravity = 6.67e-11;
   //instances: properties of the class objects
   public double xxPos, yyPos, xxVel, yyVel, mass;
   public String imgFileName;
   //constructor
   //initialize the class with parameters/instances
   public Body(double xP,double yP, double xV,double yV,double m, 
               String img){
      xxPos = xP; yyPos = yP; xxVel = xV; yyVel = yV; mass = m;
      imgFileName = img;
   }
   //constructor for making a copy of an object
   public Body(Body b){
      xxPos = b.xxPos; yyPos = b.yyPos; xxVel = b.xxVel; 
      yyVel = b.yyVel; mass = b.mass;
      imgFileName = b.imgFileName;
   }
   

   //methods
   //calcDistance is a non-static method
   //that takes a Body object and calculates 
   //the distance between two Body objects
   public double calcDistance(Body p){
      double xxDis = this.xxPos - p.xxPos;
      double yyDis = this.yyPos - p.yyPos;
      double dist;

      dist = Math.sqrt(Math.pow(xxDis,2)+Math.pow(yyDis,2));
      return dist;
   }

   public double calcForceExertedBy(Body p){
      double force;

      force = p.mass * this.mass * gravity 
         / Math.pow(this.calcDistance(p),2); 
      return force;
   }
   //calcForceExertedByX and calcForceExertedByY return the force in 
   //respective directions
   public double calcForceExertedByX(Body p){
      double xxForce;
      double xxDis; 
      if (this.mass > p.mass)
      {
         xxDis = this.xxPos - p.xxPos;
      } else
      {
         xxDis = p.xxPos - this.xxPos;
      }

      xxForce = this.calcForceExertedBy(p) * xxDis / this.calcDistance(p);
      return xxForce;
   }

   public double calcForceExertedByY(Body p){
      double yyForce;
      double yyDis; 
      if (this.mass > p.mass)
      {
         yyDis = this.yyPos - p.yyPos;
      } else
      {
         yyDis = p.yyPos - this.yyPos;
      }

      yyForce = this.calcForceExertedBy(p) * yyDis / this.calcDistance(p);
      return yyForce;
   }
   
   public double calcNetForceExertedByX(Body[] allBodys){
      double xxNetForce = 0;
         for (Body p: allBodys){
            if (this.equals(p)){
               continue;
            }
            xxNetForce += this.calcForceExertedByX(p); 
         }
         return xxNetForce;
   }

   public double calcNetForceExertedByY(Body[] allBodys){
      double yyNetForce = 0;
         for (Body p: allBodys){
            if (this.equals(p)){
               continue;
            }
            yyNetForce += this.calcForceExertedByY(p); 
         }
         return yyNetForce;
   }

   //update take a time interval, x-force and y-force to calculate
   //a new position and time
   public void update(double dt,double fx,double fy){
      double xxA;
      double yyA;

      xxA = fx/this.mass;
      yyA = fy/this.mass;

      this.xxVel += dt * xxA;
      this.yyVel += dt * yyA;

      this.xxPos += dt * this.xxVel;
      this.yyPos += dt * this.yyVel;

   }
}
