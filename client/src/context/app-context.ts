import { createContext } from "react";

export type JobFilters = {
  keyword: string;
  location: string;
  type: string;
};

export type AppContextValue = {
  isDarkMode: boolean;
  toggleDarkMode: () => void;
  filters: JobFilters;
  updateFilters: (nextFilters: Partial<JobFilters>) => void;
  resetFilters: () => void;
};

export const AppContext = createContext<AppContextValue | undefined>(undefined);
