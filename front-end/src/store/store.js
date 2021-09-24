import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    //strict: true,
    state: {
        userID:'',
        userName: '',
        questions: [
            { id: 1 , conntent: "ziad is my Name" },
            { id: 2 , conntent: "osama is my brother" }
        ],
        users:[],
        profileData:{},
        profileQuestions:{},
    },
    getters: {
        
    },
    mutations: {
        initialiseStore(state) {
            if (localStorage.getItem('userID') ) {
              state.userID = localStorage.getItem('userID');
              state.userName = localStorage.getItem('userName');
            }
        },
        saveUserData:(state , data) =>{
            localStorage.setItem('userID', data._id);
            localStorage.setItem('userName', data._name);
            state.userID = data._id;
            state.userName = data._name;
        },
        saveQuestions:(state , questions) =>{
            console.log("questions = " + questions);
            state.questions = questions;
        },
        saveUsers:(state , users) =>{
            console.log("users = " + users);
            state.users = users;
        },
        saveProfileData:(state , profileData) =>{
            console.log("profileData = " + profileData);
            state.profileData = profileData;
        },
        saveProfileQuestions:(state , profileQuestions) =>{
            console.log("profileQuestions = " + profileQuestions);
            state.profileQuestions = profileQuestions;
        },
    },
    actions: {
        getQuestions: async context =>{
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getQuestion/" + store.state.userID  + "/" + store.state.userName, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveQuestions',response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getUsers: async context =>{
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getUsers/" + store.state.userID , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveUsers', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getFollowers: async context =>{  // not done yet
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getUsers/" + store.state.userID + "/0/" + "30", {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveUsers', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        loadProfileData: async (context,_name) => { //not done yet
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getProfileData/" + store.state.userID + "/" + _name , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveProfileData', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        loadProfileQuestions: async (context,_name) => { //not done yet
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getProfileQuestion/" + store.state.userID + "/" + _name , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveProfileQuestions', response);
            /*} catch (error) {
                alert('error');
            }*/
        }
    }
});