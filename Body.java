public class Body{
	final static double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Body(double xxPos, double yyPos, double xxVel,
		double yyVel,double mass,String imgFileName){

		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
	}

	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;

	}

	public double calcDistance(Body b){
		double dx = b.xxPos - xxPos;
		double dy = b.yyPos - yyPos;
		double rSquared = Math.pow(dx, 2) + Math.pow(dy, 2);
		// double rSquared = dx * dx + dy * dy;
		double r = Math.pow(rSquared, 0.50);
		return r;
		// return Math.round(r);

	}

	public double calcForceExertedBy(Body b){
		double distance = calcDistance(b);
		// double F = (G * mass * b.mass) / Math.pow(distance, 2);
		double F = (G * mass * b.mass) / (distance * distance);
		return F;
		// return Math.round(F);
	}

	public double calcForceExertedByX(Body b){
		double force = calcForceExertedBy(b);
		double distance = calcDistance(b);
		double cosCeta = (b.xxPos - xxPos) / distance;
		double forceByxx = force * cosCeta;
		return forceByxx;
		// return Math.round(forceByxx);
	}

	public double calcForceExertedByY(Body b){
		double force = calcForceExertedBy(b);
		double distance = calcDistance(b);
		double sinCeta = (b.yyPos - yyPos) / distance;
		double forceByYY = force * sinCeta;
		return forceByYY;
		// return Math.round(forceByYY);
	}

	public double calcNetForceExertedByX(Body bodies[]){
		double forcesXX[] = new double[bodies.length];
		for(int i = 0; i < bodies.length; i = i + 1){
			if(this.equals(bodies[i])){
				continue;
			}
			forcesXX[i] = calcForceExertedByX(bodies[i]);
		}
		double sum = 0;
		for(int i = 0; i < forcesXX.length; i = i + 1){
			sum = sum + forcesXX[i];
		}
		return sum;
		

	}


	public double calcNetForceExertedByY(Body bodies[]){
		double forcesYY[] = new double[bodies.length];
		for(int i = 0; i < bodies.length; i = i + 1){
			if(this.equals(bodies[i])){
				continue;

			}
			forcesYY[i] = calcForceExertedByY(bodies[i]);
		}
		double sum = 0;
		for(int i = 0; i < forcesYY.length; i = i + 1){
			sum = sum + forcesYY[i];
		}
		return sum;
		

	}

	public void update(double time, double fXX, double fYY){
		// double time, double fXX, double fYY
		double accXX = fXX / this.mass;
		double accYY = fYY / this.mass;
		this.xxVel = this.xxVel + time * accXX;
		this.yyVel = this.yyVel + time * accYY;
		this.xxPos = this.xxPos + time * this.xxVel;
		this.yyPos = this.yyPos + time * this.yyVel;

	}

	public void draw(){
		// StdDraw.enableDoubleBuffering();
		// StdDraw.clear();
		StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);

	}




}
