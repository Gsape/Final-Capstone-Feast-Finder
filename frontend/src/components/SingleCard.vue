<template>
  <div>
    <h1>Restaurant Name</h1>

    <div v-for="list in $store.state.searchResults" :key="list.businesses">
        
        <div v-for="restaurant in list.businesses" :key="restaurant.name">
          <div class="card">
            <img :src='restaurant.image_url' alt="">
            <div class="container">
              <h4><b>{{ restaurant.name }}</b></h4>
                
                <button type="button" v-on:click="likeRestaurant(restaurant.id)">Like</button>
                <button type="button">Hate</button>
                <p>{{ restaurant.rating }}</p>
            </div>
          </div>



            <!-- <img :src='restaurant.image_url' alt="" />
            {{ restaurant.name }}
            {{ restaurant.rating }} -->
        </div>    
            
        </div>
    </div>
    
    
    <!-- <ul>
      <li v-for="list in $store.state.searchResults" :key="list.businesses">
        <p v-for="restaurant in list.businesses" :key="restaurant.name">
          {{ restaurant.name }}
        </p>
      </li>
    </ul> -->

</template>

<script lang="ts">
import Vue from "vue";
import userService from "../services/UserService";

export default Vue.extend({
  name: "single-card",
  // data() {
  //   restaurantID: ''
  // },
  methods: {
    likeRestaurant(restaurantID){
      userService.addFavorite(restaurantID).then((response) => {
        this.$store.commit("ADD_FAVORITE", response);
      })
    }
  }
});
</script>



<style scoped>

img {
    height: 200px;
    width: auto;
}

.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  border-radius: 10px;
  width: 300px;
  height: 400px;
  margin: 20px;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

/* Add some padding inside the card container */
.container {
  padding: 2px 16px;
}
</style>