import { useEffect, useMemo, useState, type ReactNode } from "react";
import { AppContext, type JobFilters } from "@/context/app-context";

const initialFilters: JobFilters = {
  keyword: "",
  location: "",
  type: "All job types",
};

export function AppProvider({ children }: { children: ReactNode }) {
  const [isDarkMode, setIsDarkMode] = useState(false);
  const [filters, setFilters] = useState<JobFilters>(initialFilters);

  useEffect(() => {
    document.documentElement.classList.toggle("dark", isDarkMode);
  }, [isDarkMode]);

  const value = useMemo(
    () => ({
      isDarkMode,
      toggleDarkMode: () => setIsDarkMode((current) => !current),
      filters,
      updateFilters: (nextFilters: Partial<JobFilters>) =>
        setFilters((current) => ({ ...current, ...nextFilters })),
      resetFilters: () => setFilters(initialFilters),
    }),
    [filters, isDarkMode],
  );

  return <AppContext.Provider value={value}>{children}</AppContext.Provider>;
}
