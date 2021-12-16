<template>
  <div> 
        <div id='wrapper' class='d-flex flex-nowrap'>
      
        <div v-for="restaurant in $store.state.favRestaurants" :key="restaurant.data.name">
          <div class="fav-card">
            <img :src='restaurant.data.image_url' alt="">
            <div>
              <div class="container">
                <h4><b>{{ restaurant.data.name }}</b></h4>
                  <p>{{ restaurant.data.location.address1 }}</p>
                  <p>{{ restaurant.data.display_phone }}</p>
              </div>
            </div>
          </div>
        </div>    
            
        </div>
    </div>

</template>



<script lang="ts">

import Vue from "vue";
import YelpService from "../services/YelpService";


export default Vue.extend({
  methods: {
  addToFaveState(restaurantID){
      this.$store.commit("ADD_FAVORITE", restaurantID);
      YelpService.getSingleRestaurant(restaurantID)
        .then((response) => {
          this.$store.commit("SET_FAV_RESTAURANTS", response)
        })
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

.fav-card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  border-radius: 10px;
  width: 300px;
  height: 400px;
  margin: 20px;
  background-color: white;
  border: 1px solid #f1f1f1;
  perspective: 1000px;
  
  

}

/* .card:hover {
  transform: rotateY(180deg);
} */

#wrapper {
  overflow-x: scroll;
  white-space: nowrap;
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.1);
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