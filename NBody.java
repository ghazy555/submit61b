public class NBody{

	public static double readRadius(String file){
		In myfile = new In(file);
		int number = myfile.readInt();
		double radius = myfile.readDouble();
		return radius;
	}

	public static Body[] readBodies(String file){
		In myfile = new In(file);
		int number = myfile.readInt();
		double radius = myfile.readDouble();
		Body bodies[] = new Body[number];
		for (int i = 0; i < number; i = i + 1){
			bodies[i] = new Body(myfile.readDouble(),
				myfile.readDouble(), myfile.readDouble(),
				myfile.readDouble(), myfile.readDouble(),
				myfile.readString());
			bodies[i].imgFileName = "./images/" + bodies[i].imgFileName;
		}
		return bodies;
		}
		
		public static void main(String[] args) {
			double T = Double.parseDouble(args[0]);
			double dt = Double.parseDouble(args[1]);
			String filename = args[2];
			double radius = readRadius(filename);
			Body bodies[] = readBodies(filename);


			// Drawing the Background
			StdDraw.setScale(-radius * 2, radius * 2);
			StdDraw.enableDoubleBuffering();
			StdDraw.clear();
			StdDraw.picture(0, 0, "./images/starfield.jpg");

			// Drawing the bodies
			// for (int i = 0; i < bodies.length; i = i + 1) {
			// 	bodies[i].draw();
			// }

			// StdDraw.show();
			// System.out.println(bodies.length);

			double time = 0;
			while(time < T){
				StdDraw.picture(0, 0, "./images/starfield.jpg");
				double xForces[] = new double[bodies.length];
				double yForces[] = new double[bodies.length];
				for (int i = 0; i < bodies.length; i = i + 1) {
					xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
					yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
					bodies[i].update(time/50, xForces[i], yForces[i]);
					bodies[i].draw();


				}
				// StdDraw.picture(0, 0, "./images/starfield.jpg");
				StdDraw.show();
				StdDraw.clear();
				StdDraw.pause(10);
				time = time + dt;

			}






			// double time = 0;
			// double xForces[] = new double[bodies.length];
			// double yForces[] = new double[bodies.length];

			// double timeStep = 0.1;
			// for (double t = 0; t < T; t = t + dt){
			// 	for (int x = 0 ; x < bodies.length; x = x + 1) {
			// 		xForces[x] = bodies[x].calcNetForceExertedByX(bodies);
			// 		yForces[x] = bodies[x].calcNetForceExertedByY(bodies);
			// 		// double a = StdRandom.uniform(-90, 90);
			// 		// double b = StdRandom.uniform(-90, 90);
			// 		bodies[x].update(t , xForces[x], yForces[x]);
			// 		StdDraw.picture(0, 0, "./images/starfield.jpg");
			// 		bodies[x].draw();
			// 		StdDraw.show();
			// 		StdDraw.pause(10);
			// 	}
					
			// }


		}


			
	}




















