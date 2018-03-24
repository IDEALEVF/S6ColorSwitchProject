CREATE TABLE niveau.`niveau2` (
  `obstacle` varchar(30) DEFAULT NULL,
  `posx` varchar(11) DEFAULT NULL,
  `posy` varchar(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `rotation` int(11) DEFAULT NULL
);
INSERT INTO niveau.`niveau2` VALUES ('Etoile','0%','0%',10,10,1,0),('Etoile','50%','50%',10,10,1,0),('Etoile','90%','90%',10,10,1,0);