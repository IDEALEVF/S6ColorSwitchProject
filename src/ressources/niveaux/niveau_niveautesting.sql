CREATE TABLE niveau.`niveautesting` (
  `obstacle` varchar(30) DEFAULT NULL,
  `posx` int(11) DEFAULT NULL,
  `posy` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `rotation` int(11) DEFAULT NULL
);
INSERT INTO niveau.`niveautesting` VALUES ('Round1',300,300,10,10,2,0);