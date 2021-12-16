<template>
  <div>
  <header>
    <banner/>
    </header>
    <h1>Recommended Restaurants</h1>
      <!-- <router-link :to="{ name: 'restaurant-details', params: { id: restaurant.id }}" v-for="r in $store.state.restaurant" v-bind:key="r.id"> -->
        <single-card />
      <!-- </router-link> -->
    <h1>Your Favorite Restaurants</h1>
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
