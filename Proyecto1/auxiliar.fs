/*********************************************************************/
/*********** TRADUCCION VENTANA VENTANAPRINCIPAL***********/
/*********************************************************************/

var VENTANAPRINCIPAL=crearVentana("#000000",500,500,"VENTANAPRINCIPAL");
VENTANAPRINCIPAL.alcargar();
var CONTENEDOR10_VENTANAPRINCIPAL=VENTANAPRINCIPAL.crearcontenedor(400,400,"#BDBDBD",verdadero,10,10);
CONTENEDOR10_VENTANAPRINCIPAL.id="CONTENEDOR1";

var LBLEVALUACION0_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearTexto("Agency FB",12,"#000000",10,10,verdadero,falso,"Haga clic en el siguiente boton para iniciar la evaluacion");
LBLEVALUACION0_CONTENEDOR10_VENTANAPRINCIPAL.nombre="LBLEVALUACION";

var BTNEVALUACION1_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearBoton("Agency FB",14,"#000000",60,40,referencia_BTNEVALUACION1_CONTENEDOR10_VENTANAPRINCIPAL(),"Iniciar Evaluacion",100,100);
BTNEVALUACION1_CONTENEDOR10_VENTANAPRINCIPAL.nombre="BTNEVALUACION";
funcion referencia_BTNEVALUACION1_CONTENEDOR10_VENTANAPRINCIPAL(){
   Bienvenido();
     VentanaAritmetica.alcargar()  ;
}

var LBLREPORTES2_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearTexto("Agency FB",12,"#000000",10,250,falso,verdadero,"Haga clic en el siguiente boton para iniciar el area de reportes");
LBLREPORTES2_CONTENEDOR10_VENTANAPRINCIPAL.nombre="LBLREPORTES";

var BTNREPORTES3_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearBoton("Agency FB",14,"#000000",60,300,referencia_BTNREPORTES3_CONTENEDOR10_VENTANAPRINCIPAL(),"Iniciar Reportes",100,100);
BTNREPORTES3_CONTENEDOR10_VENTANAPRINCIPAL.nombre="BTNREPORTES";
funcion referencia_BTNREPORTES3_CONTENEDOR10_VENTANAPRINCIPAL(){
   BienvenidoReporte();
     VentanaReportes.alcargar()  ;
}

var BTNENVIAR4_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearBoton("Agency FB",14,"#000000",60,350,referencia_BTNENVIAR4_CONTENEDOR10_VENTANAPRINCIPAL(),"Sin funcionalidad",100,100);
BTNENVIAR4_CONTENEDOR10_VENTANAPRINCIPAL.nombre="BTNENVIAR";
funcion generica_BTNENVIAR4_CONTENEDOR10_VENTANAPRINCIPAL(){
   VENTANAPRINCIPAL.crearArrayDesdeArchivo();
}
BTNENVIAR4_CONTENEDOR10_VENTANAPRINCIPAL.alclic(generica_BTNENVIAR4_CONTENEDOR10_VENTANAPRINCIPAL());
funcion referencia_BTNENVIAR4_CONTENEDOR10_VENTANAPRINCIPAL(){
   EnviarSinFuncionalidad();
}

var CTNOMBRE5_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearCajaTexto(20,100,"Agency FB",12,"#000000",100,50,falso,falso,"Ingrese aqui su nombre","CTNOMBRE");

var CPOTENCIA6_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearControlNumerico(50,100,5000,0,150,150,0,"CPOTENCIA");
CPOTENCIA6_CONTENEDOR10_VENTANAPRINCIPAL.fuente="Agency FB";
CPOTENCIA6_CONTENEDOR10_VENTANAPRINCIPAL.tam=12;
CPOTENCIA6_CONTENEDOR10_VENTANAPRINCIPAL.color="#000000";
CPOTENCIA6_CONTENEDOR10_VENTANAPRINCIPAL.negrita=falso;
CPOTENCIA6_CONTENEDOR10_VENTANAPRINCIPAL.cursiva=falso;

var lista_CDPAISAJE17_CONTENEDOR10_VENTANAPRINCIPAL=["Playa","Luna","Selva","Desierto","Oceano"];
var CDPAISAJE17_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearDesplegable(50,100,lista_CDPAISAJE17_CONTENEDOR10_VENTANAPRINCIPAL,150,250,"","CDPAISAJE1");
CDPAISAJE17_CONTENEDOR10_VENTANAPRINCIPAL.fuente="Agency FB";
CDPAISAJE17_CONTENEDOR10_VENTANAPRINCIPAL.tam=12;
CDPAISAJE17_CONTENEDOR10_VENTANAPRINCIPAL.color="#000000";
CDPAISAJE17_CONTENEDOR10_VENTANAPRINCIPAL.negrita=falso;
CDPAISAJE17_CONTENEDOR10_VENTANAPRINCIPAL.cursiva=falso;

var CHANOI8_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearAreaTexto(150,50,"Agency FB",12,"#000000",150,150,falso,falso,"","CHANOI");

var AudioIngles9_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearReproductor("Ackermann.mp3",450,50,falso,50,100);
AudioIngles9_CONTENEDOR10_VENTANAPRINCIPAL.nombre="AudioIngles";

var MULTDESIERTO10_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearImagen("Desierto.jpg",300,700,100,100);
MULTDESIERTO10_CONTENEDOR10_VENTANAPRINCIPAL.nombre="MULTDESIERTO";

var MULTDESIERTO11_CONTENEDOR10_VENTANAPRINCIPAL = CONTENEDOR10_VENTANAPRINCIPAL.CrearVideo("Desierto.mp4",300,700,falso,100,100);
MULTDESIERTO11_CONTENEDOR10_VENTANAPRINCIPAL.nombre="MULTDESIERTO";



/*********************************************************************/
/*********** FIN TRADUCCION VENTANA VENTANAPRINCIPAL***********/
/*********************************************************************/