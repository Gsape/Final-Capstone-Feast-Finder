<template>
  <div class="home">
    <h1>Feast Finder</h1>
   <b-container>
      <b-row class="vh-100" align-v="center">
        <b-col></b-col>
        <b-col> <card/> </b-col>
        <b-col></b-col>
      </b-row>   
   </b-container>    
   <side-bar/>
  </div>
</template>

<script>
import Card from '../components/card.vue';
import SideBar from '../components/sideBar.vue';
 
export default {
  components: {Card, SideBar},
  name: "home"
};
</script>

<style scoped>

</style>
