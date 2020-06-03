package formes;

import etatFleche.contextFleche;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class CreationFleche {
	
	public static void creation(Pane tableauTravail, contextFleche context, 
			Group arrow, Polygon triangleHead, Polygon triangleBack, Line curLine,
			double forme1X, double forme1Y, double forme2X, double forme2Y)
	{
	 	 //on dessine la ligne choisit auparavant
        curLine = new Line(
        		forme1X, forme1Y,
        		forme2X, forme2Y
            );  
                                
        //Couleur de fleche et style de fleche
        arrow = new Group();                        
        context.getState().setTypeFleche(curLine, triangleBack, triangleHead, arrow, forme2X, forme2Y);
        
        //ajouter de la fleche dans le tableau de travail
        tableauTravail.getChildren().add(arrow);    
	}
	
	public static void creation(Pane tableauTravail, contextFleche context, 
			Group arrow, Polygon triangleHead, Polygon triangleBack, Line curLine, 
			double forme1X, double forme1Y, double forme2X, double forme2Y, 
			double forme1MoitierHauteur, double forme1MoitierLargueur, 
			double forme2MoitierHauteur, double forme2MoitierLargueur)
	{ 
		  //premier forme selectionner
  	   double [] tempCenterX = {forme1X, 0, 0};
  	   double [] tempCenterY = {forme1Y, 0, 0};
  	   
  	   //seconde forme selectionner
  	   double [] centerX = {forme2X, 0, 0};
  	   double [] centerY = {forme2Y, 0, 0};  
  	   
  	   //pour l'axe des X
  	   if(tempCenterX[0] < centerX[0])
  	   {
  		  tempCenterX[1] = tempCenterX[0] + forme1MoitierLargueur;
  		  centerX[1] = centerX[0] - forme2MoitierLargueur;
   		  tempCenterY[1] = tempCenterY[0];
   		  centerY[1] = centerY[0];
  	   }
  	   else
  	   {
  		  tempCenterX[1] = tempCenterX[0] - forme1MoitierLargueur;
  		  centerX[1] = centerX[0] + forme2MoitierLargueur;
   		  tempCenterY[1] = tempCenterY[0];
   		  centerY[1] = centerY[0];
  	   }
  	    
  	   //pour l'axe des Y
  	   if(tempCenterY[0] < centerY[0])
  	   {
  		  tempCenterY[2] = tempCenterY[0] + forme1MoitierHauteur;
  		  centerY[2] = centerY[0] - forme2MoitierHauteur;
   		  tempCenterX[2] = tempCenterX[0];
   		  centerX[2] = centerX[0];
  	   }
  	   else
  	   {
  		   tempCenterY[2] = tempCenterY[0] - forme1MoitierHauteur;
  			centerY[2] = centerY[0] + forme2MoitierHauteur;
  			tempCenterX[2] = tempCenterX[0];
 		   	centerX[2] = centerX[0];
  	   }
  	   
  	   //on fait pythagore entre les pointes les plus proches
  	   //des deux formes
		 	double ligne1 = Math.sqrt(Math.pow((tempCenterY[1] - centerY[1]), 2) + Math.pow((tempCenterX[1] - centerX[1]), 2));
		 	double ligne2 = Math.sqrt(Math.pow((tempCenterY[2] - centerY[2]), 2) + Math.pow((tempCenterX[2] - centerX[2]), 2)); 
		 	 
		 	//on choisit quel ligne est la plus courte 
		 	//de deux ligne construit auparavant
		 	 if(ligne1 < ligne2)
		 	 {
		 		centerX[0] = centerX[1];
		 		centerY[0] = centerY[1];
		 		tempCenterY[0] = tempCenterY[1];
		 		tempCenterX[0] = tempCenterX[1];
		 	 }
		 	 else
		 	 {
		 		centerX[0] = centerX[2];
		 		centerY[0] = centerY[2];
		 		tempCenterY[0] = tempCenterY[2];
		 		tempCenterX[0] = tempCenterX[2];
		 	 }
  	   
		 	 //on dessine la ligne choisit auparavant
         curLine = new Line(
      		   tempCenterX[0], tempCenterY[0],
      		   centerX[0], centerY[0]
             );   
                                 
         //Couleur de fleche et style de fleche
         arrow = new Group();                        
         context.getState().setTypeFleche(curLine, triangleBack, triangleHead, arrow, centerX[0], centerY[0]);
         
         //ajouter de la fleche dans le tableau de travail
         tableauTravail.getChildren().add(arrow);   
	}
}
