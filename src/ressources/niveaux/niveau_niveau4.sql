CREATE TABLE niveau.`niveau4` (
  `obstacle` varchar(30) DEFAULT NULL,
  `posx` int(11) DEFAULT NULL,
  `posy` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `rotation` int(11) DEFAULT NULL
);
INSERT INTO niveau.`niveau4` VALUES ('CarreDeRonds',135,100,120,120,3,45),('ChangeColor',190,20,12,12,3,0),('Doigt',170,420,100,100,0,0),('RondDeRonds',190,-310,120,120,3,0),('ObstacleRound1',190,-310,150,150,3,45),('Carre',130,-310,200,200,3,0),('RondDeRondsAccelere',190,-310,120,120,3,0);
