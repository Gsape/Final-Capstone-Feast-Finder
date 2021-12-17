<template>
  <div id="app">

    <router-view />
  </div>
</template>


<style>
#nav{
  display: block;
  font-family:serif;
  font-size: larger;
}

@font-face {
  /* font-family: "Wabeco";
  src: local("Webeco"),
   url(./fonts/WABECO-Regular.ttf) format("truetype"); */
  font-family: "OpenSans";
  src: local("OpenSans"),
  url(./fonts/OpenSans-VariableFont_wdth,wght.ttf) format("truetype");
  font-family: "KornerDeliNF";
  src: local("KornerDeliNF"),
   url(./fonts/KornerDeliNF.ttf) format("truetype");

}

</style>