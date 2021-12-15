<template>
  <div>
  <header>
<<<<<<< Updated upstream
    <banner/>
=======
    <h1>Feast Finder</h1>
    <side-bar/>
>>>>>>> Stashed changes
    </header>
    <single-card />
   <!-- <b-container>
      <b-row class="vh-100" align-v="center">
        <b-col></b-col>
        <b-col> <card/> </b-col>
        <b-col></b-col>
      </b-row>   
<<<<<<< Updated upstream
   </b-container>    
   <router-link v-bind:to="{ name: 'test' }">LINKKKKKKKKKKKK</router-link>
      <router-link v-bind:to="{ name: 'singleCard' }">Card</router-link>

=======
   </b-container>     -->
>>>>>>> Stashed changes
  </div>
</template>

<script>
<<<<<<< Updated upstream
import Banner from '../components/banner.vue';
import Card from '../components/card.vue';
 
export default {
  components: {Card, Banner},
  name: "home"
=======
// import Card from '../components/card.vue';
import SideBar from '../components/sideBar.vue';
import SingleCard from '../components/SingleCard.vue';
 
export default {
  components: {SideBar, SingleCard},
  name: "home",
>>>>>>> Stashed changes
};
</script>



<style scoped>



header > img {
  max-width: 10%;
  margin-top: -20px;
  margin-right: 10px;
  flex-grow: 1;
}

header > h1 {
  margin-left: 20px;
  margin-top: 5px;
  flex-grow: 2;
  justify-content: flex-start;
  font-family: "Wabeco";
}

</style>
