<template>
  <div>
    <div
      v-for="list in $store.state.searchResults"
      :key="list.businesses"
      class="d-flex flex-nowrap scrollbar scrollbar-morpheus-den"
      id="wrapper"
    >
      <div
        v-for="restaurant in list.businesses"
        :key="restaurant.name"
        class="space"
      >
        <div class="flip-card">
          <div class="card-inner">
            <div class="card, card-back">
              <!-- div class="card, card-back"> -->
                <div class="container" id='container-front'>
                  <h4>
                    <b>{{ restaurant.name }}</b>
                  </h4>
                  <p>{{ restaurant.location.address1 }}</p>
                  <p>{{ restaurant.display_phone }}</p>
                  <p>Number Of Ratings: {{ restaurant.review_count }}</p>
                  <!-- <p class='url'>{{ restaurant.url }}</p> -->
                  <button
                    type="button"
                    v-on:click="addToFaveState(restaurant.id)"
                    class="btn btn-primary btn-sm"
                    id="like"
                  >
                    Like
                  </button>
                </div>

            </div>
            <div>
              <div id='card-front'>

                <img :src="restaurant.image_url" alt="" />
              <div class="container">
                <h4>
                  <b>{{ restaurant.name }}</b>
                </h4>
                <p>{{ restaurant.location.address1 }}</p>
                <p>Price: {{ restaurant.price }} | Rating: {{ restaurant.rating }}</p>
                
                
                <!-- <button
                  type="button"
                  v-on:click="addToFaveState(restaurant.id)"
                  class="btn btn-primary btn-sm"
                  id="like"
                >
                  Like
                </button> -->
              </div>

              </div>
            </div>
          </div>
          <!-- <img :src='restaurant.image_url' alt="" />
            {{ restaurant.name }}
            {{ restaurant.rating }} -->
        </div>
      </div>
    </div>
  </div>
</template>
<script lang="ts">
import Vue from "vue";
import UserService from "../services/UserService";
import YelpService from "../services/YelpService";

export default Vue.extend({
  methods: {
    addToFaveState(restaurantID) {
      // Local Changes
      this.$store.commit("ADD_FAVORITE", restaurantID);
      YelpService.getSingleRestaurant(restaurantID).then((response) => {
        this.$store.commit("SET_FAV_RESTAURANTS", response);
      });
      // Changes to Database
      const dto = {
        yelpId: restaurantID,
        isShown: false,
      };
      UserService.addFavorite(dto);
    },
  },
});
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap');
* {
  font-family: 'Open Sans', sans-serif;
}
img {
  height: 250px;
  width: 298px;
  border-radius: 10px;
}
.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  border-radius: 10px;
  width: 300px;
  height: 400px;
  
  /* display: flex; */
  background-color: red;
  border: 1px solid #f1f1f1;
    transform: rotateY(180deg);

}

.card-back {
  width: 300px;
  height: 400px;
  background-color: lightgray;
  transform: rotateY(180deg);
  border-radius: 9px;
}
.card-inner {
  position: absolute;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}
.flip-card:hover .card-inner {
  transform: rotateY(180deg);
}
.flip-card {
  background-color: white;
  width: 300px;
  height: 400px;
  border: 1px solid gray;
  perspective: 1000px;
  border-radius: 10px;
  margin: 5px
}
.card,
.card-back {
  width: 100%;
  height: 100%;
  position: absolute;
  background-color: #80ACE9;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}
/* #wrapper {
  overflow-x: scroll;
  white-space: nowrap;
  border-radius: 10px;
} */
/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}
/* Add some padding inside the card container */
.container {
  padding: 2px 16px;
  text-align: center;
  white-space: normal;
  margin: auto;
  vertical-align: center;
}

#container-front {
  padding: 100px 0px;
}

.space {
  margin: 0px 10px
}



.scrollbar-morpheus-den::-webkit-scrollbar-track {
-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.1);
background-color: transparent;
border-radius: 10px; }

.scrollbar-morpheus-den::-webkit-scrollbar {
width: 12px;
background-color: transparent; }

.scrollbar-morpheus-den::-webkit-scrollbar-thumb {
border-radius: 10px;
-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.1);
background-image: -webkit-gradient(linear, left bottom, left top, from(#30cfd0), to(#330867));
background-image: -webkit-linear-gradient(left, #30cfd0 0%, #330867 100%);
background-image: linear-gradient(to top, #30cfd0 0%, #330867 100%); }

.scrollbar-morpheus-den {
scrollbar-color: #330867 #F5F5F5;
}
</style>