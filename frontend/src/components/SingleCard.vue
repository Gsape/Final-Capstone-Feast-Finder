<template>
  <div>
    <div v-for="list in $store.state.searchResults" :key="list.businesses" class='d-flex flex-nowrap' id='wrapper'>
        
        <div v-for="restaurant in list.businesses" :key="restaurant.name" class='space'>
          <div class="card">
            <img :src='restaurant.image_url' alt="">
            <div class="container">
              <h4><b>{{ restaurant.name }}</b></h4>
                <p>{{ restaurant.location.address1 }}</p>
                <p>{{ restaurant.display_phone }}</p>
                <button type="button" v-on:click="addToFaveState(restaurant.id)" class="btn btn-primary btn-sm" id='like'>Like</button>
            </div>
          </div>



            <!-- <img :src='restaurant.image_url' alt="" />
            {{ restaurant.name }}
            {{ restaurant.rating }} -->
        </div>    
            
        </div>
    </div>
</template>

<script lang="ts">
import Vue from "vue";
import UserService from "../services/UserService";
import YelpService from '../services/YelpService'

export default Vue.extend({
  methods: {
  addToFaveState(restaurantID){
      // Local Changes
      this.$store.commit("ADD_FAVORITE", restaurantID);
       YelpService.getSingleRestaurant(restaurantID)
        .then((response) => {
          this.$store.commit("SET_FAV_RESTAURANTS", response)
        });
      // Changes to Database
      const dto = {
        yelpId: restaurantID,
        isShown: false
      }
      UserService.addFavorite(dto);
    }
  }
});
</script>



<style>

@import url('https://fonts.googleapis.com/css2?family=Vidaloka&display=swap');

* {
    font-family: 'Vidaloka', serif;
}

img {
    height: 200px;
    width: auto;
    border-radius: 10px;
}

.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  border-radius: 10px;
  width: 300px;
  height: 400px;
  margin: 20px;
  display: flex;
  background-color: light;
  border: 1px solid #f1f1f1;
  perspective: 1000px;
  /* justify-content: center; */

}

/* .card:hover {
  transform: rotateY(180deg);
} */

#wrapper {
  overflow-x: scroll;
  white-space: nowrap;
border-radius: 10px
}


/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

/* Add some padding inside the card container */
.container {
  padding: 2px 16px;
  text-align: center;
  white-space: normal;
  margin: auto;
  vertical-align: center;
}

.space {
   position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

 #like {
   margin: auto
}





</style>