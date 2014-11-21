package com.example.olho;

/*
 * Classe para usar um vetor unidimensional de pixels,
 * no algoritmo da distorção de barrel.
 */
public class fish {
    
    private int index__(int x, int y, int n_x) // (x, y, width)
    {
        return (y*n_x+x);
    }
    
    /* algoritmo da distorção de barrel.
     * OBS: estudá-la melhor.
     * \/ */
    public int[] olho_de_peixe(int []pixels, int width, int height) 
    {
        double w = width;
        double h = height;
        int []pixels2 = new int[width * height];
        
        for (int y=0;y<h;y++) 
        {                                
            double ny = ((2*y)/h)-1;                        
            double ny2 = ny*ny;                                

            for (int x=0;x<w;x++) 
            {                            
                double nx = ((2*x)/w)-1;                    
                double nx2 = nx*nx;
                double r = Math.sqrt(nx2+ny2);                

                if (0.0<=r&&r<=1.0) 
                {                            
                    double nr = Math.sqrt(1.0-r*r);            
                    nr = (r + (1.0-nr)) / 2.0;
                    if (nr<=1.0) 
                    {
                        double theta = Math.atan2(ny,nx);         
                        double nxn = nr*Math.cos(theta);        
                        double nyn = nr*Math.sin(theta);        
                        int x2 = (int)(((nxn+1)*w)/2.0);        
                        int y2 = (int)(((nyn+1)*h)/2.0);        

                        if ( (x2 > 0 && x2 < w) && (y2 > 0 && y2 < h) ) 
                        {                            
                            pixels2[index__(x, y, width)] = pixels[index__(x2, y2, width)];      		
                        }

                    }
                }
            }
        }
        return pixels2;
    } 
    
}
