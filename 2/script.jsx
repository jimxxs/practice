
import React from 'react';

const MenuItem = ({ title, price, description, imageSrc }) => (
  <div className="flex flex-col space-y-4 mb-12">
    {imageSrc && (
      <div className="w-full aspect-square rounded-lg overflow-hidden">
        <img 
          src={imageSrc || "/api/placeholder/400/400"} 
          alt={title}
          className="w-full h-full object-cover"
        />
      </div>
    )}
    <div className="space-y-2">
      <div className="flex justify-between items-center">
        <h3 className="text-xl font-semibold tracking-wide">{title}</h3>
        <span className="text-amber-300">UGX {price.toLocaleString()}</span>
      </div>
      <p className="text-gray-400 text-sm">{description}</p>
    </div>
  </div>
);

const MenuSection = ({ title, items }) => (
  <div className="mb-16">
    <div className="text-center mb-12">
      <div className="flex items-center justify-center space-x-4 mb-4">
        <div className="h-px w-12 bg-amber-300/30" />
        <div className="w-2 h-2 bg-amber-300/30 transform rotate-45" />
        <div className="w-2 h-2 bg-amber-300/30 transform rotate-45" />
        <div className="w-2 h-2 bg-amber-300/30 transform rotate-45" />
        <div className="h-px w-12 bg-amber-300/30" />
      </div>
      <h2 className="text-3xl tracking-wide">{title}</h2>
    </div>
    <div className="max-w-2xl mx-auto px-6">
      {items.map((item, index) => (
        <MenuItem key={index} {...item} />
      ))}
    </div>
  </div>
);

const PhilozMenu = () => {
  // Example menu items - replace with your actual menu
  const menuSections = {
    "Main Courses": [
      {
        title: "GRILLED CHICKEN",
        price: 35000,       
        description: "Marinated chicken breast, served with seasonal vegetables and mashed potatoes",
      },
      // Add more items...
    ],
  };

  return (
    <div className="min-h-screen bg-gray-900 text-white py-12">
      {Object.entries(menuSections).map(([title, items]) => (
        <MenuSection key={title} title={title} items={items} />
      ))}
    </div>
  );
};

export default PhilozMenu;