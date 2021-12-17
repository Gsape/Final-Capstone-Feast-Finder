<template>
  <div id="feastForm">
    <container class='login-image-container'>
    <img id='login-image' src="loginpagecopy.jpg"/>
    </container>
    <h1>Feast Form</h1>
    <feastForm />
  </div>
</template>
<script>
import feastForm from "@/components/feastForm.vue";

export default {
  components: {
    feastForm
  }

};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap');

* {
    font-family: 'Open Sans', sans-serif;
}

#login-image {
    position: absolute;
    width: 100%;
    padding: auto;
    margin: auto;
    left: 0px;
    top: 0px;
    z-index: -1;
    object-fit: contain;
}
</style>