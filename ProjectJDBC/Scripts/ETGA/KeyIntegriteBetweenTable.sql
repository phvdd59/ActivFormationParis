alter table dbetga.produit add constraint idTetgaFK
foreign key (idTetga) references dbetga.tetga(ID);