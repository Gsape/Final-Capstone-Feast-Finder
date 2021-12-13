<template>
  <div>
    <h1>Restaurant</h1>
    <h2>{{ JSONObject }}</h2>

    <h1>Yelp Token</h1>
    <h1>Loved Restaurant Ids</h1>
    <h1>Hated Restaurant Ids</h1>
    <h1>List of Restaurants</h1>
    <h1>Profile</h1>
    <h1></h1>
    <h1></h1>
    <h1></h1>
    <h1></h1>
  </div>
</template>

<script>
import yelpService from "../services/YelpService";

export default {
  name: "data-test",
  data() {
    return {
      businessID: 0,
      reponseJSON: {}
    };
  },

  //   gR9DTbKCvezQlqvD7_FzPw

  methods: {
    getRestaurant() {
      yelpService
        .getSingleRestaurant('gR9DTbKCvezQlqvD7_FzPw') // this.$route.params.businessID
        .then((response) => {
          this.$store.commit("SET_RESTAURANT", response.data.restaurant);
        });
    },

    // submitRestaurant() {
    //     const newRestaurant = {
    //         businessID: this.restaurant.businessID,
    //         business: this.restaurant.business,
    //         address: this.restaurant.address,
    //         imgURL: this.restaurant.imgURL,
    //         phone: this.restaurant.phone,
    //         rating: this.restaurant.rating,
    //         price: this.restaurant.price,
    //         cuisine: this.restaurant.cuisine
    //
    // },
  },

  created() {
    this.getRestaurant();
  },

  computed: {
    restaurant() {
      return this.$store.state.restaurant;
    },

    JSONObject() {
      return this.$store.state.reponseJSON;
    }
  },

  
};
</script>