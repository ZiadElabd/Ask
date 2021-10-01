import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    //strict: true,
    state: {
        userID:'',
        userName: '',
        userImage: "",
        questions: [],
        cur_question:{},
        users:[],
        followers:[],
        profileData:{},
        profileQuestions:[],
        homeQuestions:[],
        settings:{},
        notifications:[],
    },
    getters: {
        
    },
    mutations: {
        initialiseStore(state) {
            if (localStorage.getItem('userID') ) {
              state.userID = localStorage.getItem('userID');
              state.userName = localStorage.getItem('userName');
              state.userImage = localStorage.getItem('userImage');
            }
        },
        saveUserData:(state , data) =>{
            localStorage.setItem('userID', data._id);
            localStorage.setItem('userName', data._name);
            state.userID = data._id;
            state.userName = data._name;
        },
        saveImage:(state , image) =>{
            localStorage.setItem('userImage', image);
            state.userImage = image;
        },
        deleteUserData:(state) =>{
            localStorage.setItem('userID', '');
            localStorage.setItem('userName', '');
            localStorage.setItem('userImage','');
            state.userID = '';
            state.userName = '';
            state.userImage = '';
        },
        saveQuestions:(state , questions) =>{
            state.questions = questions;
        },
        deleteAQuestion(state, questionID){
            state.questions = state.questions.filter( q => q.stringID != questionID );
        },
        saveAQuestion:(state , question) =>{
            state.cur_question = question;
        },
        saveUsers:(state , users) =>{
            state.users = users;
        },
        saveFollowers:(state , followers) =>{
            state.followers = followers.map(e => {
                return e.userName;
            });
        },
        saveProfileData:(state , profileData) =>{
            state.profileData = profileData;
        },
        saveProfileQuestions:(state , profileQuestions) =>{
            state.profileQuestions = profileQuestions;
        },
        saveHomeQuestions:(state , homeQuestions) =>{
            state.homeQuestions = homeQuestions;
        },
        saveSettings:(state , settings) =>{
            state.settings = settings;
        },
        saveNotifications:(state , notifications) =>{
            state.notifications = notifications;
        },

    },
    actions: {
        getImage: async context => {
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getProfilePhoto/" + store.state.userID  + "/" + store.state.userName, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("nav image")
                console.log("questions response = " + response);
                context.commit('saveImage', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getQuestions: async context => {
            //try {
                let response = await fetch( "http://localhost:5050/getQuestion/" + store.state.userID  + "/" + store.state.userName, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                context.commit('saveQuestions',response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getAQuestion: async (context,question_id) => {
            //try {
                console.log('question id in store =  ' + question_id);
                let response = await fetch( "http://localhost:5050/getAskAnsQuestion/" + store.state.userID  + "/" + question_id, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                context.commit('saveAQuestion',response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getNotifications: async context =>{
            //try {
                let response = await fetch( "http://localhost:5050/getNotifactions/" + store.state.userID, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                context.commit('saveNotifications', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getUsers: async context =>{
            //try {
                let response = await fetch( "http://localhost:5050/getUsers/" + store.state.userID , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                context.commit('saveUsers', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getFollowers: async context =>{ 
            //try {
                let response = await fetch( "http://localhost:5050/getFollowers/" + store.state.userID + "/" + store.state.userName, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                context.commit('saveFollowers', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        loadProfileData: async (context,_name) => { 
            //try {
                let response = await fetch( "http://localhost:5050/getProfileData/" + store.state.userID + "/" + _name , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                context.commit('saveProfileData', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        loadProfileQuestions: async (context,_name) => { 
            //try {
                let response = await fetch( "http://localhost:5050/getProfileQuestion/" + store.state.userID + "/" + _name , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                context.commit('saveProfileQuestions', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        loadHome: async context => { //not done yet
            //try {
                let response = await fetch( "http://localhost:5050/getHomeQuestion/" + store.state.userID + "/" + store.state.userName , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                context.commit('saveHomeQuestions', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        like: (context,question_id) => {
            fetch(
                "http://localhost:5050/AddLike/" + store.state.userID + "/" + store.state.userName + "/" + question_id,
                {
                  method: "post",
                  headers: { "Content-Type": "application/json" },
                }
            );
        },
        unlike: (context,question_id) => {
            fetch(
                "http://localhost:5050/removeLike/" + store.state.userID + "/" + store.state.userName + "/" + question_id,
                {
                  method: "post",
                  headers: { "Content-Type": "application/json" },
                }
            );
        },
        loadSettings: async context => {
            //try {
                let response = await fetch( "http://localhost:5050/getSettings/" + store.state.userID + "/" + store.state.userName, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                context.commit('saveSettings', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
    },
    
});