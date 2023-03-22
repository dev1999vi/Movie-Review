import './App.css';
import api from './api/axiosConfig';
import { useState , useEffect } from 'react';
import { Layout } from './components/Layout';
import { Route, Routes } from 'react-router-dom';
import { Home } from './pages/home/Home';
import { Header } from './pages/home/Header';
import { Trailer } from './pages/home/Trailer';

function App() {

  const [movies, setMovies]=useState([]);
  const getMovies= async () =>{

    try{
        const response = await api.get("/api/v1/movies");
        setMovies(response.data);
    }catch(err){
      console.log(err);
    }
    
  }

  useEffect(()=>{
    getMovies();
  },[])

  return (
    <div className="App">
      <Header />
      <Routes >
        <Route path='/' element={<Layout />}>
          <Route path='/' element={<Home movies={movies}/>} ></Route>
          <Route path='/Trailer/:ytTrailerId' element={<Trailer/>} ></Route>
        </Route>
      </Routes>
      <Layout />
    </div>
  );
}

export default App;
