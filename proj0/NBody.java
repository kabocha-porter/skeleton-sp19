public class NBody{
   //readRadius reads input from a universe file and returns the
   //radius, the second input entry
   public static double readRadius(String file){
     //args is the file name 
      In in = new In(file);
      //this could be a public variable 
      int N = in.readInt();
      double R = in.readDouble();
      return R;
   }

   //readBodies take a string as file name and return 
   //an array of Body with parameters specified in the file
   public static Body[] readBodies(String file){
      In in = new In(file);

      int N = in.readInt();
      Body[] bodys= new Body[N];

      double R = in.readDouble();
   
      for(int i = 0; i < N; ++i ){
         double xxPos = in.readDouble();
         double yyPos = in.readDouble(); 
         double xxVel = in.readDouble();
         double yyVel = in.readDouble();
         double mass = in.readDouble();
         String img = in.readString();
         bodys[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, img);
      }
      return bodys;
   }

   public static void main(String[] args){
      if (args.length == 0){
         System.out.println("Please supply T and dt.");
      }
      //reading input from the command line as T and dt
      String stringT = args[0]; 
      double T = Double.parseDouble(stringT);
      String stringDt = args[1]; 
      double dt = Double.parseDouble(stringDt); 
      String filename = args[2]; 
      //read from file using the file name just specified 
      double radius = readRadius(filename);
      Body[] bodys = readBodies(filename);
      int N = bodys.length;
      //reset the scale to math the input and drawing the backgroud
      String pic = "images/starfield.jpg";
      StdDraw.setXscale(-radius,radius);
      StdDraw.setYscale(-radius,radius);
      StdDraw.picture(0, 0, pic);
      //drawing Body objects with draw() in Body.java
      for (int i=0; i<N; ++i){ 
      bodys[i].draw();
      }

      StdDraw.enableDoubleBuffering();
      int time = 0;

      //T is a double, while time is int
      while (time < T){
         //calculate the net force on each Body and store 
         //each Body's infor in the bodys array
         double xForces[] = new double[N];
         double yForces[] = new double[N];

         for(int i=0; i<N; ++i){
            xForces[i] = bodys[i].calcNetForceExertedByX(bodys);
            yForces[i] = bodys[i].calcNetForceExertedByY(bodys);
         }

         //update position based on forces calculated above and time
         //interval 1s.
         for(int i=0; i<N; ++i){
            bodys[i].update(dt,xForces[i],yForces[i]);
         }
          
         //redraw the image with the same process
         StdDraw.picture(0,0, pic);
         for (int i=0; i<N; ++i){ 
            bodys[i].draw();
         }
         
         StdDraw.show();
         StdDraw.pause(10);
         time += dt; 

      }
         //print out the final states 
         StdOut.printf("%d\n", N);
         StdOut.printf(".2e\n", radius);
         StdOut.printf("The final states of the stars are:\n");
         for (int i=0; i<N; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          bodys[i].xxPos, bodys[i].yyPos, bodys[i].xxVel,
                          bodys[i].yyVel, bodys[i].mass, bodys[i].imgFileName);
         }
   }
}

