package com.training.opengl;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
 
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
 

public class Renderer {

	int m_width;
	int m_height;
	long window;
	
	public Renderer(int width, int height, String title){
		
		m_width = width;
		m_height = height;
		
		try{
			GLFWErrorCallback.createPrint(System.err).set();
			
			if(!glfwInit()){
				throw new IllegalStateException("Unable to initialize GLFW");
			}
			
			window = glfwCreateWindow(m_width, m_height, "Hello World!", NULL, NULL);
			if(window == NULL){
				throw new RuntimeException("Failed to create the GLFW window");
			}
			
			glfwDefaultWindowHints();
			glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
			glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
			
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
			
			glfwSetWindowPos(window, (vidmode.width() - m_width)/2, (vidmode.height()-m_height)-2);
			glfwMakeContextCurrent(window);
			glfwSwapInterval(1);
			glfwSetWindowTitle(window, title);
			glfwShowWindow(window);
			
		}catch(Exception E){
			
		}
	}
	
	public void loop(){
		GL.createCapabilities();
		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
		 while ( !glfwWindowShouldClose(window) ) {
	            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
	            glfwSwapBuffers(window);
	            glfwPollEvents();
	        }
	}
	public void freeWindow(){
		glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
	}
}
