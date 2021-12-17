<template>
  <div class>
  <header>
    <banner/>
  </header>
    <div v-if="this.$store.state.searchResults.length === 0" class="instructions">
      <h1>Welcome to Feast Finder!</h1>
      <p>
        <ul>Right now, this page is as empty as your tummy :(</ul>
        <ul>To fill both, click the Feast Form button to select any of the foods you might be interested in eating today.</ul>
        <ul>When you submit, you'll have a feast of choices before you!</ul>
        <ul>Hover over a card to see more details about that restaurant.</ul>
        <ul>Click the "Like button" to save the restaurant as a favorite in your profile.</ul>
      </p>
    </div>
    <div v-else class="GoEat">
      <h1 class="sections">Recommended Restaurants</h1>
        <!-- <router-link :to="{ name: 'restaurant-details', params: { id: restaurant.id }}" v-for="r in $store.state.restaurant" v-bind:key="r.id"> -->
          <single-card />
        <!-- </router-link> -->
      <h1 class="sections">Your Favorite Restaurants</h1>
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

h1.sections {
  justify-content: flex-start;
  font-family: "KornerDeliNF";
  color:whitesmoke;
  letter-spacing: 2.5px;
}

.GoEat{
  margin-left: 15px;
  margin-top: -40px;
}

.faveHeader{
  padding-top: 20px;
}

</style>
