import React from 'react';
import { Hero } from './Hero';

export const Home = ({movies}) => {
  return (
    <div>
        <h1>Movies</h1>
        <Hero movies= {movies}/>
    </div>    
  )
}
