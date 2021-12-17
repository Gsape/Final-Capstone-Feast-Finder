<template>
  <div class>
  <header>
    <banner/>
  </header>
    <div v-if="this.$store.state.searchResults.length === 0" class="instructions">
      <h1>Welcome to Feast Form!</h1>
      <p>
        <ul>This is your home page.</ul>
        <ul>Right now, this page is as empty as your tummy.</ul>
        <ul>To fill both, click the Feast Form button to select any of the foods you might be interested in eating today.</ul>
        <ul>When you submit, you'll have a feast before you!</ul>
        <ul>Hover over a card to see more details about that restaurant.</ul>
        <ul>Click the "Like button" to save the restaurant as a favorite in your profile.</ul>
      </p>
    </div>
    <div v-else>
      <h1>Recommended Restaurants</h1>
        <!-- <router-link :to="{ name: 'restaurant-details', params: { id: restaurant.id }}" v-for="r in $store.state.restaurant" v-bind:key="r.id"> -->
          <single-card />
        <!-- </router-link> -->
      <h1>Your Favorite Restaurants</h1>
      <fav-card />
    </div>
  </div>
</template>

<script>
import Banner from "../components/banner.vue";
import FavCard from "../components/favCard.vue";
import SingleCard from "../components/SingleCard.vue";

export default {
  components: { Banner, SingleCard, FavCard },
  name: "home",
};
</script>



<style scoped>


ul {
  text-align: center;
  font-size: 25px;
}

.instructions {
  width: 60%;
  margin: auto;
}

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
