package org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI;


import android.graphics.*;
import android.graphics.drawable.*;

	public class drawable {

		private static GradientDrawable.Orientation ori;
		
		
		
		
		private static GradientDrawable initRoundBG(int[] Colors,float[] Corner,String Ori){
			if(Ori == "上下"){
				ori = GradientDrawable.Orientation.TOP_BOTTOM;
			}else if(Ori == "上右"){
				ori = GradientDrawable.Orientation.TR_BL;
			}else if(Ori == "右左"){
				ori = GradientDrawable.Orientation.RIGHT_LEFT;
			}else if(Ori == "下右"){
				ori = GradientDrawable.Orientation.BR_TL;
			}else if(Ori == "下上"){
				ori = GradientDrawable.Orientation.BOTTOM_TOP;
			}else if(Ori == "RT"){
				ori = GradientDrawable.Orientation.BL_TR;
			}else if(Ori == "左右"){
				ori = GradientDrawable.Orientation.LEFT_RIGHT;
			}else if(Ori == "RB"){
				ori = GradientDrawable.Orientation.TL_BR;
			};
			GradientDrawable dra=new GradientDrawable();
			dra.setGradientType(GradientDrawable.LINEAR_GRADIENT);
			dra.setCornerRadii(Corner);
			dra.setOrientation(ori);//设置方向
			dra.setColors(Colors);//设置渐变颜色数组
			return dra;
		};


		public static GradientDrawable RoundBG(int[] Colors, float[] Corner, String Ori){
			float[] Radii = new float[]{
				Corner[0],Corner[0],Corner[1],Corner[1],Corner[2],Corner[2],Corner[3],Corner[3]
			};
			//封装.上面的
			return initRoundBG(Colors,Radii,Ori);
		};

		public static GradientDrawable RoundBG(int Colors, float[] Corner, String Ori){
			float[] Radii = new float[]{
				Corner[0],Corner[0],Corner[1],Corner[1],Corner[2],Corner[2],Corner[3],Corner[3]
			};
			int[] colors = new int[]{
				Colors,Colors
			};
			//封装.上面的
			return initRoundBG(colors,Radii,Ori);
		};


		public static GradientDrawable RoundBG(int[] Colors, int Corner, String Ori){
			float[] Radii = new float[]{
				Corner,Corner,Corner,Corner,Corner,Corner,Corner,Corner
			};
			//封装.上面的
			return initRoundBG(Colors,Radii,Ori);
		};

		public static GradientDrawable RoundBG(int Colors, int Corner, String Ori){
			float[] Radii = new float[]{
				Corner,Corner,Corner,Corner,Corner,Corner,Corner,Corner
			};
			int[] colors = new int[]{
				Colors,Colors
			};
			//封装.上面的
			return initRoundBG(colors,Radii,Ori);
		};


		public static GradientDrawable Round(String Cr,float[] Corner){
			//四个圆角的顺序为LT，RT，RB，LB。
			float[] Radii = new float[]{
				Corner[0],Corner[0],Corner[1],Corner[1],Corner[2],Corner[2],Corner[3],Corner[3]
			};
			GradientDrawable bg = new GradientDrawable();
			bg.setColor(Color.parseColor(Cr)); //颜色
			bg.setCornerRadii(Radii);
			return bg;
		};

		public static GradientDrawable Round(String Cr,int Corner){
			//四个圆角的顺序为LT，RT，RB，LB。
			float[] Radii = new float[]{
				Corner,Corner,Corner,Corner,Corner,Corner,Corner,Corner
			};
			GradientDrawable bg = new GradientDrawable();
			bg.setColor(Color.parseColor(Cr)); //颜色
			bg.setCornerRadii(Radii);
			return bg;
		};

		

	}

