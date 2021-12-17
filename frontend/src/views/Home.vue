<template>
  <div>
  <header>
    <banner/>
  </header>
    <h1 class="sections">Recommended  Restaurants</h1>
      <!-- <router-link :to="{ name: 'restaurant-details', params: { id: restaurant.id }}" v-for="r in $store.state.restaurant" v-bind:key="r.id"> -->
        <single-card />
      <!-- </router-link> -->
    <h1 class="sections">Your  Favorite  Restaurants</h1>
    <fav-card />
  </div>
</template>

<script>
import Banner from '../components/banner.vue';
import FavCard from '../components/favCard.vue';
import SingleCard from '../components/SingleCard.vue';
 
export default {
  components: {Banner, SingleCard, FavCard},
  name: "home",

};
</script>



<style scoped>


h1.sections {

  justify-content: flex-start;
  font-family: "KornerDeliNF";
  color:whitesmoke;
  letter-spacing: 2.5px;
}

</style>
