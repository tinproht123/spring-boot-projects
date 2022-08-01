import React from "react";
import ListEmployee from "./components/ListEmployee";
import Header from "./components/Header";
import AddEmployee from "./components/AddEmployee";
import Footer from "./components/Footer";

import { Routes, Route } from "react-router-dom";

const App = () => {
  return (
    <div>
      <Header />
      <Routes>
        <Route path="/" element={<ListEmployee />} />
        <Route path="/employees" element={<ListEmployee />} />
        <Route path="/add-employee" element={<AddEmployee />} />
        <Route path="/edit-employee/:id" element={<AddEmployee />} />
      </Routes>

      <Footer />
    </div>
  );
};

export default App;
