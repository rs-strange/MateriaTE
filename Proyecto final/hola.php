
<?php
//$i=0;
//$valor=$_GET['si'];
//echo "valor ".$valor;
$respuesta=array();
$sintomas=array("diarrea","tos","cansancio","fiebre","dolor de cabeza"
	,"nauseas","ictericia","apatia","escalofrios","jaqueca","secrecion");


if(isset($_GET['Submit']))
{
	echo "presiono boton si";
	//$respuesta=$sintomas[$i];
	//print_r($respuesta);
	//$i=$i+1;

}else if(isset($_GET['no']))
{
	echo "presiono boton no";
	//$i=$i+1;
}

?>

<form method="get" action="<?php echo $_SERVER['PHP_SELF']; ?>">
<p>¿Usted padece de ddffd?</p>
<p><input type="submit" name="si" value="si">
<input type="submit" name="no" value="no">

	<br></p>
</form>

<?php
/*

$RespUsuario=array("tos", "cansancio", "fiebre", "dolor de cabeza");
$Gripe=array("tos","fiebre", "dolor de cabeza","cansancio");
$Rubeola=array("fiebre","escalofrios","jaqueca","secrecion");
$Malaria=array("diarrea","fiebre","ictericia","escalofrios");
$Hepatitis=array("diarrea","nauseas","ictericia");
$Tuberculosis=array("tos","cansancio","fiebre","escalofrios");
$Anemia=array("cansancio","nauseas","apatia");

//$uno=array("uno","dos","tres","cuatro");
//$dos=array("uno","dos","cuatro");

//print_r(array_diff($dos,$uno));

$uno=array_diff($Gripe,$Rubeola);
echo "uno"."<br />";
print_r($uno);

echo "dos"."<br />";
$dos=array_diff($Gripe,$Malaria);
print_r($dos);

echo "tres"."<br />";
$tres=array_diff($Gripe,$Hepatitis);
print_r($tres);

echo "cuatro";
$cuatro=array_diff($Gripe,$Tuberculosis);
print_r($cuatro);

echo "cinco";
$cinco=array_diff($Gripe,$Anemia);
print_r($cinco);

echo "seis";
$seis=array_diff($Rubeola,$Malaria);
print_r($seis);

echo "siete";
$siete=array_diff($Rubeola,$Hepatitis);
print_r($siete);

echo "ocho";
$ocho=array_diff($Rubeola,$Tuberculosis);
//print_r($ocho);

echo "nueve";
$nueve=array_diff($Rubeola,$Anemia);
//print_r($nueve);

echo "diez";
$diez=array_diff($Malaria,$Hepatitis);
//print_r($siete);

echo "once";
$once=array_diff($Malaria,$Tuberculosis);
//print_r($once);

echo "doce";
$doce=array_diff($Malaria,$Anemia);
//print_r($doce);

echo "trece";
$trece=array_diff($Hepatitis,$Tuberculosis);
//print_r($trece);

echo "catorce";
$catorce=array_diff($Hepatitis,$Anemia);
//print_r($catorce);
*/
?>