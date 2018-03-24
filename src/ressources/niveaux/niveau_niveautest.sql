CREATE TABLE niveau.`niveautest` (
  `obstacle` varchar(30) DEFAULT NULL,
  `posx` int(11) DEFAULT NULL,
  `posy` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `rotation` int(11) DEFAULT NULL
);
INSERT INTO niveau.`niveautest` VALUES ('Round1',300,300,10,10,1,0),('ObstacleRound1',190,200,45,45,3,45),('ChangeColor',190,20,45,45,3,0),('ObstacleRound1',190,-200,45,45,3,45),('CroixG',190,-400,45,45,1,0),('Etoile',190,-600,45,45,3,0),('LigneFin',0,-700,300,3,3,0);